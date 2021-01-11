function toggle_case(inp) {
    var str1 = "";
    for (var i = 0; i < inp.length; i++) {
        if (/[A-Z]/.test(inp[i])) str1 += inp[i].toLowerCase();
        else str1 += inp[i].toUpperCase();
    }
    return str1;
}
console.log(toggle_case("hELLO I AM rAGHAV"));
