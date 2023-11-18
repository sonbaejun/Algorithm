function solution(triangle) {
  // 결국 tree를 완전탐색 해야되는거 아닌가? 이게 맞네
  // 밑에서 부터 고를 수 있는 경우의 수 2개중 더 큰 경우의 수를 더해줘 가는 방식

  let sum = triangle[0][0];

  for (let i = triangle.length - 1; i > 0; i--) {
    for (let j = 0; j < triangle[i].length - 1; j++) {
      let temp = Math.max(triangle[i][j], triangle[i][j + 1]);
      triangle[i - 1][j] += temp;
    }
  }

  return triangle[0][0];
}
