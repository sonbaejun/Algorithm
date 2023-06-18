function solution(msg) {
    var answer = [];
    let LZWDictionary = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
    msg = msg.split('');
    while (msg.length > 0) {
        /* 타겟 문자 추출 */
        let word = msg.splice(0, 1).join('');
        let cnt = 0;
        let num = 0;
        let index = LZWDictionary.indexOf(word);
        /* 사전에 없는 단어일때까지 반복 */
        while (index != -1) {
            index = LZWDictionary.indexOf(word);
            /* 정답번호와 사전에 단어 추가 / 다음 단어 추가 후 탐색 */
            if (index == -1 || msg.length < cnt) {
                answer.push(num);
                LZWDictionary.push(word);
                msg.splice(0, cnt - 1);
            } else {
                num = index + 1;
                word += msg[cnt];
                cnt++;
            }
        }
    }
    return answer;
}