function solution(cacheSize, cities) {
    var answer = 0;
    let cache = [];
    /* 대소문자 구분 안하므로 모두 대문자로 변경 */
    cities = cities.map(e => e.toUpperCase())
    /* 캐시사이즈가 0일 경우 예외처리 */
    if (cacheSize == 0) answer = cities.length * 5;
    cities.map(e => {
        let index = cache.indexOf(e); // cache hit or miss 판단
        /* hit이면 순서갱신, miss면 캐시가 full인지 아닌지에 따라 갱신 */
        if (index != -1) {
            answer++;
            cache.splice(index, 1);
            cache.splice(0, 0, e);
        } else {
            answer += 5;
            /* cache가 꽉 차 있을땐 LRU정책에 따라 가장 늦게 쓴 놈을 내보낸다 */
            if (cacheSize == cache.length) {
                cache.pop();
                cache.splice(0, 0, e);
            } else {
                cache.splice(0, 0, e);
            }
        }
    })
    return answer;
}