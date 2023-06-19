function solution(arr) {
    var answer = [];
    while (arr.length > 0) {
        let cnt = 1;
        let element = arr.splice(0, 1).join('');
        while (1) {
            let index = arr.indexOf(parseInt(element));
            if (index == -1) {
                break;
            } else {
                element = arr.splice(index, 1);
                cnt++;
            }
        }
        if(cnt > 1) {
            answer.push(cnt);
        }
    }
    if(answer.length == 0) {
        answer = [-1];
    }
    return answer;
}

solution([1, 2, 3, 4, 5, 6, 7]);