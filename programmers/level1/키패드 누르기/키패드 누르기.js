function solution(numbers, hand) {
    var answer = '';
    /* 현재 손 위치(가로,세로) + 초기값은 각 *과 # */
    let currentLeftHand = 3;
    let currentRightHand = 3;
    let currentMiddleNumber = -1;
    let currentLeftRow = 1;
    let currentRightRow = 1;
    let leftNumber = [1, 4, 7];
    let rightNumber = [3, 6, 9];
    let middleNumber = [2, 5, 8, 0];
    /* 왼쪽일때, 오른쪽일때, 가운데일때로 나누어 진행하고 누르게 되는 손 위치 계속 갱신 */
    numbers.forEach((e) => {
        if (e == 1 || e == 4 || e == 7) {
            currentLeftHand = leftNumber.indexOf(e);
            currentLeftRow = 1;
            answer += "L";
        } else if (e == 3 || e == 6 || e == 9) {
            currentRightHand = rightNumber.indexOf(e);
            currentRightRow = 1;
            answer += "R";
        } else {
            /* 가운데 누를 번호와의 거리 계산 후 누를 손 결정 */
            currentMiddleNumber = middleNumber.indexOf(e);
            leftDistance = Math.abs(currentMiddleNumber - currentLeftHand) + currentLeftRow;
            rightDistance = Math.abs(currentMiddleNumber - currentRightHand) + currentRightRow;
            if (leftDistance > rightDistance) {
                currentRightHand = middleNumber.indexOf(e);
                currentRightRow = 0;
                answer += "R";
            } else if (leftDistance < rightDistance) {
                currentLeftHand = middleNumber.indexOf(e);
                currentLeftRow = 0;
                answer += "L";
            } else {
                if (hand == 'left') {
                    currentLeftHand = middleNumber.indexOf(e);
                    currentLeftRow = 0;
                    answer += "L";
                } else {
                    currentRightHand = middleNumber.indexOf(e);
                    currentRightRow = 0;
                    answer += "R";
                }
            }
        }
    })
    return answer;
}