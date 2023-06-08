function solution(new_id) {
    let uppers =
        ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
    let lowers = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
    let arr = new_id.split('');
    /* 1번조건 */
    arr.map((e, i) => {
        let index = uppers.indexOf(e);
        if (index != -1)
            arr[i] = lowers[index];
    })
    /* 체이닝 부분 - 2,3,4단계 */
    new_id = arr.join('')
        .replace(/[^a-z0-9-_.]/g, '')
        .replace(/\.{2,}/g, '.')
        .replace(/^\./, '')
        .replace(/\.$/, '');
    /* 5,6 단계 */
    if (new_id.length == 0) {
        new_id = 'a';
    } else if (new_id.length >= 16) {
        arr = new_id.split('');
        new_id = arr.slice(0, 15).join('');
        new_id = new_id.replace(/\.$/, '');
    }
    /* 7단계 */
    if (new_id.length == 1) {
        let lastWord = new_id;
        new_id += lastWord;
        new_id += lastWord;
    } else if (new_id.length == 2) {
        arr = new_id.split('');
        new_id += arr[1];
    }
    return new_id
}