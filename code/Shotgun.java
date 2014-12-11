/* Shotgun.java */

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * The Shotgun class contains the method shotgunSequencing(), which implements the
 * shotgun sequencing algorithm for finding the shortest accurate DNA sequence.
 */

public class Shotgun {

	/**
	 * shotgunSequencing() returns a single string that is the shortest accurate DNA
	 * sequence that encompasses all fragments.
	 *
	 * @param l a list of dna fragments in the form of strings
	 * @return a single string that is the shortest accurate DNA sequence
	 */
	public static String shotgunSequencing(List<String> frags) {
		while (frags.size() != 1) {
			int[] p = findMax(frags);
			String a = frags.get(p[0]);
			String b = frags.get(p[1]);
			frags.set(p[0], merge(a,b));
			frags.remove(p[1]);
		}
		String result = frags.get(0);
		return result;
	}

	/**
	 * merge() returns a single string that concatenates two strings together
	 * with overlap.
	 *
	 * @param s1 the first string to concatenate
	 * @param s2 the second string to concatenate
	 * @return the concatenation of s1 and s2 with overlap
	 */
	public static String merge(String s1, String s2) {
		if (s1.contains(s2)) {
			return s1;
		}
		if (s2.contains(s1)) {
			return s2;
		}
		if (!s1.contains(s2.substring(0,1))) {
			return s1 + s2;
		}
   		int idx = s2.length();
  	 	try {
     		while (!s1.endsWith(s2.substring(0, idx))) {
     			if (idx == 0) {
     				return s1 + s2;
     			}
     			else {
     				idx--;
     			}
     		}
   		} catch (Exception e) { }
   		if (idx == s2.length()) {
   			return s1;
   		}
   		return s1 + s2.substring(idx);
	}

	/**
	 * overlap() returns the size of overlap between two strings.
	 *
	 * @param s1 the first string in overlap comparison
	 * @param s2 the second string in overlap comparison
	 * @return the int size of overlap between s1 and s2
	 */
	public static int overlap(String s1, String s2) {
		if (s1.contains(s2)) {
			return s2.length();
		}
		if (s2.contains(s1)) {
			return s1.length();
		}
		if (!s1.contains(s2.substring(0,1))) {
			return 0;
		}
   		int idx = s2.length();
  	 	try {
     		while (!s1.endsWith(s2.substring(0, idx))) {
     			if (idx == 0) {
     				return 0;
     			}
     			else {
     				idx--;
     			}
     		}
   		} catch (Exception e) { }
   		return s2.substring(0, idx).length();
	}

	/**
	 * findMax() returns an array of size 2 that contains the pair of strings in
	 * the given list that have the maximum overlap.
	 *
	 * @param frags the list of strings
	 * @return the pair of strings with the greatest overlap stored in an array
	 */
	public static int[] findMax(List<String> frags) {
		int max = 0;
		int[] pair = new int[2];
		for (int i = 0; i < frags.size(); i++) {
			for (int j = 0; j < frags.size(); j++) {
				if (i != j) {
					if (overlap(frags.get(i),frags.get(j)) > max) {
						max = overlap(frags.get(i),frags.get(j));
						pair[0] = i;
						pair[1] = j;
					}
				}
			}
		}
		return pair;
	}

	public static void main(String[] args) {
        String file1 = "Dataset/reads1.txt";
        
        /*String file1 = "Test/test1.txt";
        String file2 = "Test/test2.txt";
        String file3 = "Test/test3.txt";*/
        
        String file2 = "Dataset/reads2.txt";
        String file3 = "Dataset/reads3.txt";
        String file4 = "Dataset/reads4.txt";
        String file5 = "Dataset/reads5.txt";
        String file6 = "Dataset/reads6.txt";
        String file7 = "Dataset/reads7.txt";
        String file8 = "Dataset/reads8.txt";
        String file9 = "Dataset/reads9.txt";
        String file10 = "Dataset/reads10.txt";
        String file11 = "Dataset/reads11.txt";
        String file12 = "Dataset/reads12.txt";
        String file13 = "Dataset/reads13.txt";
        String file14 = "Dataset/reads14.txt";
        String file15 = "Dataset/reads15.txt";
        String file16 = "Dataset/reads16.txt";
 
        try {
            List<String> lines1 = Files.readAllLines(Paths.get(file1),
                    Charset.defaultCharset());
            List<String> lines2 = Files.readAllLines(Paths.get(file2),
                    Charset.defaultCharset());
            List<String> lines3 = Files.readAllLines(Paths.get(file3),
                    Charset.defaultCharset());
            List<String> lines4 = Files.readAllLines(Paths.get(file4),
                    Charset.defaultCharset());
            List<String> lines5 = Files.readAllLines(Paths.get(file5),
                    Charset.defaultCharset());
            List<String> lines6 = Files.readAllLines(Paths.get(file6),
                    Charset.defaultCharset());
            List<String> lines7 = Files.readAllLines(Paths.get(file7),
                    Charset.defaultCharset());
            List<String> lines8 = Files.readAllLines(Paths.get(file8),
                    Charset.defaultCharset());
            List<String> lines9 = Files.readAllLines(Paths.get(file9),
                    Charset.defaultCharset());
            List<String> lines10 = Files.readAllLines(Paths.get(file10),
                    Charset.defaultCharset());
            List<String> lines11 = Files.readAllLines(Paths.get(file11),
                    Charset.defaultCharset());
            List<String> lines12 = Files.readAllLines(Paths.get(file12),
                    Charset.defaultCharset());
            List<String> lines13 = Files.readAllLines(Paths.get(file13),
                    Charset.defaultCharset());
            List<String> lines14 = Files.readAllLines(Paths.get(file14),
                    Charset.defaultCharset());
            List<String> lines15 = Files.readAllLines(Paths.get(file15),
                    Charset.defaultCharset());
            List<String> lines16 = Files.readAllLines(Paths.get(file16),
                    Charset.defaultCharset());

            PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
            String result1 = shotgunSequencing(lines1);
            String result2 = shotgunSequencing(lines2);
            String result3 = shotgunSequencing(lines3);
            String result4 = shotgunSequencing(lines4);
            String result5 = shotgunSequencing(lines5);
            String result6 = shotgunSequencing(lines6);
            String result7 = shotgunSequencing(lines7);
            String result8 = shotgunSequencing(lines8);
            String result9 = shotgunSequencing(lines9);
            String result10 = shotgunSequencing(lines10);
            String result11 = shotgunSequencing(lines11);
            String result12 = shotgunSequencing(lines12);
            String result13 = shotgunSequencing(lines13);
            String result14 = shotgunSequencing(lines14);
            String result15 = shotgunSequencing(lines15);
            String result16 = shotgunSequencing(lines16);

            writer.println(result1);
            writer.println(result2);
            writer.println(result3);
            writer.println(result4);
            writer.println(result5);
            writer.println(result6);
            writer.println(result7);
            writer.println(result8);
            writer.println(result9);
            writer.println(result10);
            writer.println(result11);
            writer.println(result12);
            writer.println(result13);
            writer.println(result14);
            writer.println(result15);
            writer.println(result16);
            writer.close();

            /*PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
			for (String line : lines) {
				writer.println(line);
			}
			writer.close();
			
			PrintWriter writer2 = new PrintWriter("testfindMax.txt", "UTF-8");
			int[] fm1 = findMax(lines1);
			int[] fm2 = findMax(lines2);
			int[] fm3 = findMax(lines3);
			writer2.println("String 1: " + fm1[0] + " String 2: " + fm1[1]);
			writer2.println("String 1: " + fm2[0] + " String 2: " + fm2[1]);
			writer2.println("String 1: " + fm3[0] + " String 2: " + fm3[1]);
			writer2.close();

            PrintWriter writer3 = new PrintWriter("testmerge.txt", "UTF-8");
			String m1 = merge(lines1.get(fm1[0]), lines1.get(fm1[1]));
			String m2 = merge(lines2.get(fm2[0]), lines2.get(fm2[1]));
			String m3 = merge(lines3.get(fm3[0]), lines3.get(fm3[1]));
			writer3.println("max overlap merge 1: " + m1);
			writer3.println("max overlap merge 2: " + m2);
			writer3.println("max overlap merge 3: " + m3);
			writer3.close();

            PrintWriter writer4 = new PrintWriter("testshotgun.txt", "UTF-8");
            String result = shotgunSequencing(lines);
            writer4.println(result);
            writer4.close();*/
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}