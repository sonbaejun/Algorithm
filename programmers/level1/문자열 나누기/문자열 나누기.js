function solution(s) {
    var answer = 0;
    let arr = s.split('');
    let xCnt = 0;
    let nonXCnt = 0;
    let x = '';
    arr.map(e => {
        /* 첫 x가 없다면 해당 요소를 x로 지정 */
        if (x == '') {
            x = e;
            xCnt++;
        } else {
            /* 같은지 다른지에 따라 카운트 후 카운트가 같아졌으면 정답횟수를 늘리고 초기화 */
            e == x ? xCnt++ : nonXCnt++;
            if (xCnt == nonXCnt) {
                answer++;
                xCnt = 0;
                nonXCnt = 0;
                x = '';
            }
        }
    })
    if (x != '') answer++; // 만약 배열이 남아있다면 정답횟수 +1
    return answer;
}