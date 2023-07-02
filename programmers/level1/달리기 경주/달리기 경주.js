function solution(player, calling) {
    const map = new Map();
    const map2 = new Map();
    player.forEach((e, i) => {
        map.set(e, i)
    })
    player.forEach((e, i) => {
        map2.set(i, e)
    })

    for (let i = 0; i < calling.length; i++) {
        if (map.get(calling[i]) !== 0) {
            const playerName = calling[i]; // soe
            const playerScore = map.get(playerName); // 1
            const playerNewScore = playerScore - 1; // 0
            const OtherName = map2.get(playerScore - 1) // mumu
            const OtherScore = playerScore - 1 // 0
            const OtherNewScore = playerScore // 1

            map.set(playerName, playerNewScore) // soe, 0
            map.set(OtherName, OtherNewScore) // mumu, 1
            map2.set(playerScore, OtherName) // 1, mumu
            map2.set(OtherScore, playerName) // 0, soe
        }
    }
    let arr = [];
    for (let [key, val] of map.entries()) {
        arr[val] = key
    }
    return arr
}