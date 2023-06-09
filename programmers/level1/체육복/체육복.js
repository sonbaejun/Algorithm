function solution(n, lost, reserve) {
    var answer = n - lost.length;
    let reserveLength = reserve.length;
    let lostLength = lost.length;
    /* 낮은 순번대로 정렬 */
    lost = lost.sort();
    /* 여분이 있는데 도난당한 학생 먼저 소거 */
    for (let i = 0; i < lostLength; i++) {
        let index = reserve.indexOf(lost[i]);
        if (index != -1) {
            reserve.splice(index, 1);
            lost.splice(i, 1);
            i--;
            lostLength--;
        }
    }
    /* 이후 앞뒤학생 체크 */
    lost.map((e) => {
        let index = reserve.indexOf(e - 1);
        if (index == -1) {
            index = reserve.indexOf(e + 1);
            if (index != -1)
                reserve.splice(index, 1)
        } else
            reserve.splice(index, 1);
    });
    answer += reserveLength - reserve.length;
    return answer;
}