/* 일반 풀이(효율성 검사 통과 못함) */
function solution(s) {
    let arr = s.split('');
    let index = 0;
    while (index < arr.length && arr.length > 0) {
        if (arr[index] == arr[index + 1]) {
            arr.splice(index, 2);
            index -= 1;
        } else {
            index++;
        }
    }
    return arr.length == 0 ? 1 : 0
}
/* 스택 풀이(효율성 검사 통과) */
function solution(s) {
    let arr = s.split('');
    let stack = [];
    /* 배열 전체 순회 */
    arr.map(e => {
        if (stack.length == 0) {
            stack.push(e); // 스택 길이가 0이면 스택에 요소 push
        } else {
            stack[stack.length - 1] == e ? stack.pop() : stack.push(e) // 스택 마지막과 요소가 같으면 pop, 아니면 push
        }
    })
    return stack.length == 0 ? 1 : 0; //스택이 비어있따면 1, 아니면 0
}