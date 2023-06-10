function solution(N, stages) {
    let solve = [];
    let reachStage = new Array(N + 1).fill(0);
    let clearStage = new Array(N).fill(0);
    let answer = new Array(N).fill(0);
    /* index순 정렬을 위해 객체 생성 */
    answer.map((e, i) => {
        let obj = {};
        obj.index = i + 1;
        obj.value = 0;
        answer[i] = obj;
    })
    /* 스테이지 도달과 클리어를 각각 계산 */
    stages.map((e, i) => {
        for (let j = 0; j < e; j++) {
            reachStage[j]++;
        }
        for (let k = 0; k < e - 1; k++) {
            clearStage[k]++;
        }
    })
    /* 도달이 없으면 실패율 0 처리, 있으면 클리어/도달 */
    answer.map((e, i) => {
        reachStage[i] == 0 ? answer[i].value = 1 : answer[i].value = clearStage[i] / reachStage[i];
    })
    /* 실패율 순 정렬, 같을 시 인덱스 순 정렬 */
    answer.sort((a, b) => {
        return b.value == a.value ? b.index - a.index : b.value - a.value;
    })
    /* 인덱스 번호 넣기 */
    answer.map(e => {
        solve.push(e.index);
    })
    return solve.reverse();
}