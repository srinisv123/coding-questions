import java.math.BigInteger;

public class GoogleQuestion1 {
    
    public static void main(String[] args) {
        // Dimensions of the map
        int h = 52;
        int w = 52;

        BigInteger[][] map = new BigInteger[h][w];
        // Initilize top row of the map
        for (int i = 0; i < w; i++) 
            map[0][i] = new BigInteger("1");
        // Initilize left column of the map
        for (int i = 0; i < h; i++) 
            map[i][0] = new BigInteger("1");
        
        // Calclulate rest of the map
        for (int i = 1; i < w; i++)
            for (int j = 1; j < h; j++)
                map[j][i] = map[j-1][i].add(map[j][i-1]);
        
        // Display the corner value
        System.out.println(map[h - 1][w - 1]);
    }
    
}

