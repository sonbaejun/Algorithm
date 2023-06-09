function solution(sizes) {
    let maxX = 0;
    let maxY = 0;
    let bigger = 0;
    sizes.map((e) => {
        e[0] > e[1] ? bigger = 0 : bigger = 1;
        if (bigger == 0) {
            maxX < e[0] ? maxX = e[0] : maxX = maxX;
            maxY < e[1] ? maxY = e[1] : maxY = maxY;
        } else {
            maxX < e[1] ? maxX = e[1] : maxX = maxX;
            maxY < e[0] ? maxY = e[0] : maxY = maxY;
        }
    })
    return maxX * maxY;
}