function solution(s) {
    let spliceZero = 0;
    let cnt = 0;
    while (1) {
        cnt++;
        let arr = s.split('');
        let arrLength = arr.length;
        for (let i = arrLength - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr.splice(i, 1);
            }
        }
        spliceZero += arrLength - arr.length;
        s = arr.length.toString(2);
        if (s == "1") break;
    }
    return [cnt, spliceZero];
}