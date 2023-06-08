function solution(common) {
    var answer = 0;
    let plusNumber = nextNumber(common);
    if (plusNumber[0] == 1) {
        answer = common[common.length - 1] + plusNumber[1];
    } else {
        answer = common[common.length - 1] * plusNumber[1];
    }
    return answer;
}

function nextNumber(common) {
    let separator = [2, 0];
    if (common[0] == common[1] == common[2]) {
        separator[0] = 0;
        separator[1] = 1;
    } else if (common[2] - common[1] == common[1] - common[0]) {
        separator[0] = 1;
        separator[1] = common[2] - common[1];
    } else {
        separator[0] = 0;
        separator[1] = common[2] / common[1];
    }
    return separator;
}