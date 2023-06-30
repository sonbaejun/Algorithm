function solution(s) {
    let spliceZero = 0;
    let cnt = 0;
    while (s.length > 1) {
        cnt++;
        let arr = s.split('');
        let arrLength = arr.length;
        /* 0제거 */
        for (let i = arrLength - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr.splice(i, 1);
            }
        }
        spliceZero += arrLength - arr.length;
        s = arr.length.toString(2); // 2진수 변환
        if (s == "1") return [cnt, spliceZero]; // return value
    }
}