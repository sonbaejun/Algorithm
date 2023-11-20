function solution(s) {
  // 체크 => '(' ')' 이 패턴이면 그 두개 삭제?
  // 그리고 절대 나올 수 없는 경우의 수 삭제 =>
  // 1. 0번 인덱스가 ')'
  // 2. 마지막 인덱스가 '('
  // 3. ')('모양

  var answer = true;

  let sArr = s.split(""); // 배열 생성
  /* 1번 2번 경우의 수 cut */
  sArr[0] == ")" || sArr[sArr.length - 1] == "(" ? (answer = false) : null;
  if (!answer) return answer;

  /* stack으로 체크 진행 */
  let stack = [];
  sArr.map((e) => {
    if (stack.length == 0 && e == ")") {
      answer = false;
    }
    if (stack.length == 0 && e == "(") {
      stack.push(e);
    } else if (stack[stack.length - 1] == "(") {
      e == ")" ? stack.pop() : stack.push(e);
    }
  });

  stack.length != 0 ? (answer = false) : null;

  return answer;
}
