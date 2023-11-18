function solution(number) {
  // 완전탐색
  // 이중 반복문 사용
  // 전체 배열 순회 + 그 다음 인덱스부터 전체 배열 순회
  // 인덱스의 합에서 0이 되는 숫자가 배열에 존재하는지 그 다음 인덱스부터 순회
  // 있다면 추가, 없다면 땡

  var answer = 0;

  for (let j = 0; j < number.length - 2; j++) {
    for (let i = j + 1; i < number.length; i++) {
      let findEle = (number[j] + number[i]) * -1;
      findEle == -0 ? (findEle = 0) : null;
      for (let k = i + 1; k < number.length; k++)
        number[k] == findEle ? answer++ : null;
    }
  }

  return answer;
}
