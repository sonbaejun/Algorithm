function solution(progresses, speeds) {
  /* progresses를 순회하며 sppeds를 더해준다 */
  /* 한바퀴를 다 돌면 제일 앞 인덱스가 100인지 확인한다. */
  /* 제일 앞 인덱스부터 뒤 인덱스가 100이 넘었는지 연속적으로 확인 */
  /* 그럼 이게 왜 스택이냐? 아니지 큐지. FIFO. */
  var answer = [];
  let i = 0;

  while (i < 100) {
    /* 개발 진행 */
    progresses.map((e, index) => {
      progresses[index] += speeds[index];
    });

    /* 배포 가능 기능들 배포 */
    let cnt = 0;
    while (progresses.length != 0) {
      if (progresses[0] < 100) {
        break;
      } else {
        progresses.splice(0, 1);
        speeds.splice(0, 1);
        cnt++;
      }
    }
    /* 배포한게 있다면 배포 작업 수 추가 + 더 이상 작업이 없다면 반복문 탈출 */
    cnt != 0 ? answer.push(cnt) : null;
    progresses.length == 0 ? (i = 100) : i++;
  }
  return answer;
}
