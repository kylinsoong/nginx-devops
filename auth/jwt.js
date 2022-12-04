function jwt(r, data) {
    var arr = data.split('.')
    var parts = arr.slice(0,2)
        .map(v=>Buffer.from(v, 'base64url').toString())
        .map(JSON.parse);
    return { headers:parts[0], payload:parts[1], sign:arr[2] };
}

function jwt_payload_append(r) {
    var t = jwt(r, r.headersIn.Authorization.slice(7))
    t.payload.dept = "DevOps"
    t.payload.env = "Production"
    t.payload.key = "value"

    let s = [t.headers, t.payload].map(JSON.stringify)
                            .map(v=>Buffer.from(v).toString('base64url'))
                            .join('.');
    let t_new = "Bearer " +s + "." + t.sign
    r.log(t_new)
    return t_new;
}

export default {jwt, jwt_payload_append}
