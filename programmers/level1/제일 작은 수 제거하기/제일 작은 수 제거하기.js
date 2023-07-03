function solution(arr) {
    let answer = [...arr]; // spread를 통해 배열을 깨고 새로운 배열로 선언
    let min = arr.sort((a, b) => b - a).pop(); // 최소값 추출
    let index = answer.indexOf(min);
    answer.splice(index, 1);
    return answer.length == 0 ? [-1] : answer;
}