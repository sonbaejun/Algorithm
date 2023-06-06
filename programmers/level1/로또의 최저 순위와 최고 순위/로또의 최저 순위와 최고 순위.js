function solution(lottos, win_nums) {
    var answer = [];
    let rank = [1, 2, 3, 4, 5, 6];
    let hit = [6, 5, 4, 3, 2, 1];
    let zeroCnt = 0;
    let maximum = 0;
    let minimum = 0;
    lottos.map((e) => {
        if (e == 0)
            zeroCnt++;
        else {
            let cnt = win_nums.indexOf(e);
            if (cnt != -1)
                minimum++;
        }
    })
    maximum = zeroCnt + minimum;
    let index = hit.indexOf(maximum);
    if (maximum == 0) {
        maximum = 6;
    } else {
        maximum = rank[index];
    }
    console.log(minimum);
    index = hit.indexOf(minimum);
    if (minimum == 0) {
        minimum = 6;
    } else {
        minimum = rank[index];
    }
    answer.push(maximum);
    answer.push(minimum);
    return answer;
}