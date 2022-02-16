class Solution:
    @classmethod
    def uniqueLetterString(cls, param):
        n = len(param)

        a = defaultdict(list)
        for i in range(n):
            a[s[i]].append(i)
        print(a)
        ans = 0
        for p in a.values():
            print(p)
            m = len(p)
            for i in range(m):
                l,r = 0,0
                if i==0:
                    l = p[i] + 1
                else:
                    l = p[i] - p[i-1]
                if i<m-1:
                    r = p[i+1] - p[i]
                else:
                    r = n - p[i]
                ans += l*r
        return ans
    if __name__ == '__main__':
        Solution.uniqueLetterString("LEETCODE")