function solution(people, limit) {
  // Greedy, 가장 높은 무게부터 최대한 제거하는 방식으로 진행.
  // 풀이는 맞는데 효율성 테스트 통과 실패..
  // 제일 큰값부터 페어를 찾으니 최악의 경우 계속 49,999번 탐색해서 그런듯?
  // 배열 순회는 최대 50,000이지만 몸무게로 재면 최대 200회니까 이게 더 빠르겠다!

  // leftPointer + rightPointer < limit 되는 시점을 찾으면 그 사이는 다 2명씩 태울 수 있음
  // 그걸 포인트로 ㄱㄱ, O(N)이여야 효율성 통과하는듯?
  var answer = 0;
  people.sort((a, b) => {
    return b - a;
  });
  let leftPointer = 0;
  let rightPointer = people.length - 1;
  while (leftPointer <= rightPointer) {
    if (people[leftPointer] + people[rightPointer] > limit) {
      answer += 1;
      leftPointer++;
    } else {
      answer += 1;
      leftPointer++;
      rightPointer--;
    }
  }
  return answer;
}
