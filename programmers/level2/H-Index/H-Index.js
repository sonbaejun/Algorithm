function solution(citations) {
  /* 애시당초 문제를 잘못이해함 h번 이상 인용된 논문 h편 이상 => 배열 요소 얘기하는게 아니라 그냥 최대값부터 쭉 내려가야되는거임.*/

  // h번 이상 인용된 논문이 h편 이상 => 배열을 내림차순 정렬
  // 배열을 순회하며 element 와 index를 비교하면 되겠네?
  // 근데 위 조건을 만족하면 거기에 + 나머지 논문이 h번 이하 인용 => 내림차순 정렬이면 자동해결

  let maxValue = citations.length;

  citations.sort((a, b) => {
    return b - a;
  });

  while (maxValue >= 0) {
    let cnt = 0;
    for (let i = 0; i < citations.length; i++) {
      if (citations[i] >= maxValue) {
        cnt++;
      } else {
        break;
      }
    }
    if (cnt >= maxValue) {
      return maxValue;
    } else {
      maxValue--;
    }
  }
}
