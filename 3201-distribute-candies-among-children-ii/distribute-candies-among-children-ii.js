/**
 * @param {number} n
 * @param {number} limit
 * @return {number}
 */
var distributeCandies = function(n, limit) {
  let count = 0;
  const m = Math.min(limit, n);
  for (let i = 0; i <= m; i++) {
    const remaining = n - i;
    const maxPair = Math.min(limit, remaining);
    const minPair = remaining - maxPair;
    if (minPair > limit) continue;
    count += maxPair - minPair + 1;
  }
  return count;
};