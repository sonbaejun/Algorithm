function solution(k, score) {
    var answer = [];
    let currentScore = [];
    score.forEach((e) => {
        /* 배열에 빈 공간이 있는 경우 => 단순 최저점 추출 */
        if (k > currentScore.length) {
            currentScore.push(e);
            let pushNumber = minimumNumber(currentScore);
            answer.push(pushNumber);
        } else {
            /* 배열이 꽉 찬 경우 => 최저점과 현재 숫자 비교 후 진행 */
            let pushNumber = minimumNumber(currentScore);
            let replaceNumber = pushNumber;
            if (pushNumber < e) {
                let index = 0;
                while (index < currentScore.length) {
                    if (currentScore[index] == replaceNumber) {
                        currentScore[index] = e;
                        index = 1001;
                    } else {
                        index++;
                    }
                }
                pushNumber = minimumNumber(currentScore);
            }
            answer.push(pushNumber);
        }
    })
    return answer;
}

/* 최저점을 추출하는 함수 */
function minimumNumber(score) {
    let returnNumber = score[0];
    score.forEach((e) => {
        if (e < returnNumber) {
            returnNumber = e;
        }
    })
    return returnNumber;
}