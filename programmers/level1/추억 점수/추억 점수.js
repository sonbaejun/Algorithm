/* 처음 풀었던 풀이 */
function solution(name, yearning, photo) {
    var answer = [];
    for (let i = 0; i < photo.length; i++) {
        let score = 0;
        for (let j = 0; j < photo[i].length; j++) {
            let index = name.indexOf(photo[i][j]);
            if (index != -1)
                score += yearning[index];
        }
        answer.push(score);
    }
    return answer;
}

/* 이후 map & reduce 사용법 익히고 해본 풀이 */
function solution(name, yearning, photo) {
    var answer = [];
    photo.map((e) => {
        let sum = e.reduce((acc, cur) => {
            let i = name.indexOf(cur);
            if (i != -1) {
                acc += yearning[i];
            }
            return acc;
        }, 0)
        answer.push(sum);
    })
    return answer;
}