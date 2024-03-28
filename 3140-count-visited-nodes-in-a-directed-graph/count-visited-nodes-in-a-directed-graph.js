/**
 * @param {number[]} edges
 * @return {number[]}
 */
var countVisitedNodes = function(edges) {
    
    const v = edges.length
    const visited = new Set()
    const ans = Array(v).fill(0)

    const dfs = (node, component = [node]) => {
        visited.add(node)
        let next = edges[node]

        // check if cycle
        while (!visited.has(next)) {
            component.push(next)
            visited.add(next)
            next = edges[next]
        }

        const j = component.indexOf(next) // where cycle starts
        const size = component.length // size of cycle

        // if next is present in current path
        if (j >= 0) {
            for (let i = j; i < component.length; i++) {
                if(!ans[component[i]]) ans[component[i]] = size - j
            }
            for (let i = 0; i < j; i++) {
                if (!ans[component[i]]) ans[component[i]] = size - i
            }
        } else {
            for (let i = 0; i < component.length; i++) {
                if(!ans[component[i]]) ans[component[i]] = size - i + ans[next]
            }
        }
    }

    for (let i = 0; i < v; i++) if (!ans[i]) dfs(i)

    return ans 
};