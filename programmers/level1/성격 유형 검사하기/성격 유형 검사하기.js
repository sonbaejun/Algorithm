function solution(survey, choices) {
    var answer = '';
    let score = [-1, 3, 2, 1, 0, 1, 2, 3]; // 선택지 점수
    /* 각 유형별로 배열 생성 */
    let RT = [0, 0];
    let CF = [0, 0];
    let JM = [0, 0];
    let AN = [0, 0];
    /* 유형별로 나눠서 접근 */
    survey.map((e, index) => {
        /* 선택지에 맞춰서 해당 유형에 점수 부여 */
        if (e == "RT" || e == "TR") {
            if (e == "RT") {
                choices[index] < 4 ? RT[0] += score[choices[index]] : RT[1] += score[choices[index]]
            } else {
                choices[index] < 4 ? RT[1] += score[choices[index]] : RT[0] += score[choices[index]]
            }
        } else if (e == "CF" || e == "FC") {
            if (e == "CF") {
                choices[index] < 4 ? CF[0] += score[choices[index]] : CF[1] += score[choices[index]]
            } else {
                choices[index] < 4 ? CF[1] += score[choices[index]] : CF[0] += score[choices[index]]
            }
        } else if (e == "JM" || e == "MJ") {
            if (e == "JM") {
                choices[index] < 4 ? JM[0] += score[choices[index]] : JM[1] += score[choices[index]]
            } else {
                choices[index] < 4 ? JM[1] += score[choices[index]] : JM[0] += score[choices[index]]
            }
        } else {
            if (e == "AN") {
                choices[index] < 4 ? AN[0] += score[choices[index]] : AN[1] += score[choices[index]]
            } else {
                choices[index] < 4 ? AN[1] += score[choices[index]] : AN[0] += score[choices[index]]
            }
        }
    })
    /* 점수 비교하여(같으면 사전순 => 등호로 표현) 유형 집어넣기  */
    RT[0] >= RT[1] ? answer += 'R' : answer += 'T';
    CF[0] >= CF[1] ? answer += 'C' : answer += 'F';
    JM[0] >= JM[1] ? answer += 'J' : answer += 'M';
    AN[0] >= AN[1] ? answer += 'A' : answer += 'N';
    return answer;
}