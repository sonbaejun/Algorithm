function solution(brown, yellow) {
  // brown + yellow = 48
  // 48의 약수인데 무조건 앞에께 크게
  // 48/1 , 24/2, 12/4, 8/6
  // 모든 경우의 수 완전탐색 = 48/1 부터 가로 < 세로 될때까지 탐색
  // 각 경우마다 Brown으로 테두리 형성이 되는지 확인
  // 테두리 확인 => Brown >= (가로*2) + (세로-1)
  // + 테두리 안에 빈 공간을 채울만큼 yellow가 있는지 (내가 생각못한 부분)
  var answer = [brown, yellow];
  let sum = brown + yellow;
  sumSqrt = Math.sqrt(sum);
  sumSqrt = Math.floor(sumSqrt);
  for (let i = 2; i <= sumSqrt; i++) {
    if (sum % i == 0) {
      // width가 가로, height가 세로
      let width = sum / i;
      let height = i;
      let check = width * 2 + (height - 1);
      if (brown >= check && (width - 2) * (height - 2) == yellow) {
        answer = [width, height];
        break;
      }
    }
  }
  return answer;
}
