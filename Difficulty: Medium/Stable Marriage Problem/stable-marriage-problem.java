class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        
        int n = men.length;

        // result[i] = woman matched with man i
        int[] result = new int[n];

        // womanPartner[j] = man matched with woman j
        int[] womanPartner = new int[n];

        // nextProposal[i] = next woman index in preference list to propose
        int[] nextProposal = new int[n];

        // whether man is free
        boolean[] freeMen = new boolean[n];

        for(int i = 0; i < n; i++) {
            womanPartner[i] = -1;
            freeMen[i] = true;
        }

        // Create ranking array for women
        // rank[w][m] = preference rank of man m for woman w
        int[][] rank = new int[n][n];

        for(int w = 0; w < n; w++) {
            for(int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        int freeCount = n;

        while(freeCount > 0) {

            int man = -1;

            // find free man
            for(int i = 0; i < n; i++) {
                if(freeMen[i]) {
                    man = i;
                    break;
                }
            }

            // next preferred woman
            int woman = men[man][nextProposal[man]];
            nextProposal[man]++;

            if(womanPartner[woman] == -1) {
                // woman is free
                womanPartner[woman] = man;
                freeMen[man] = false;
                freeCount--;
            }
            else {
                int currentPartner = womanPartner[woman];

                // check preference
                if(rank[woman][man] < rank[woman][currentPartner]) {
                    // she prefers new man
                    womanPartner[woman] = man;
                    freeMen[man] = false;
                    freeMen[currentPartner] = true;
                }
            }
        }

        // prepare result (man → woman mapping)
        for(int w = 0; w < n; w++) {
            result[womanPartner[w]] = w;
        }

        return result;
    }
}
