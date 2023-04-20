function jwt(r, data) {
    var arr = data.split('.')
    var parts = arr.slice(0,2)
        .map(v=>Buffer.from(v, 'base64url').toString())
        .map(JSON.parse);
    return { headers:parts[0], payload:parts[1], sign:arr[2] };
}

function jwt_payload_tier(r) {
    var t = jwt(r, r.headersIn.Authorization.slice(7))
    let t_new = t.payload.tier
    return t_new;
}

export default {jwt, jwt_payload_tier}
