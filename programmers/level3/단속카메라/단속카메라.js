function solution(routes) {
  // 진출시점 기준으로 정렬 =>
  routes.sort((a, b) => {
    return a[1] - b[1];
  });

  let camera = [];
  let cnt = 0;

  routes.map((e, index) => {
    if (camera.length == 0) {
      camera.push(e[1]);
      cnt++;
    }

    for (let i = 0; i < camera.length; i++) {
      // 범위 내에 카메라 설치가 돼 있다면 통과
      if (e[0] <= camera[i] && e[1] >= camera[i]) break;
      // 범위에 맞는 카메라가 없는 경우
      if (camera.length == i + 1) {
        camera.push(e[1]);
        cnt++;
      }
    }
  });

  return cnt;
}
