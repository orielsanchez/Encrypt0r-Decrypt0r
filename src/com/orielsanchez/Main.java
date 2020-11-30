package com.orielsanchez;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String mode = "enc";
        String in = null;
        String out = null;
        int key = 0;
        String data = "";
        String alg = "shift";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode" -> mode = args[++i];
                case "-key" -> key = Integer.parseInt(args[++i]);
                case "-data" -> data = args[++i];
                case "-in" -> in = args[++i];
                case "-out" -> out = args[++i];
                case "-alg" -> alg = args[++i];
            }
        }

        if ("dec".equalsIgnoreCase(mode)) {
            key = -key;
        }

//        if (data.equals("") && in != null) {
//            data = Files.readString(Path.of(in));
//        }

        if (data.equals("") && in != null) {
            File in1 = new File(in);
            FileReader fr = new FileReader("src/resources/" + in1);
            BufferedReader br = new BufferedReader(fr);
            data = br.readLine();
        }

        PrintStream printStream = out == null ? System.out : new PrintStream(out);

        if (alg.equals("unicode")) {
            for (char c : data.toCharArray()) {
                c = (char) (c + key);
                printStream.print(c);
            }
        } else if (alg.equals("shift")) {
            Context context = new Context(new ShiftAlgorithm());
            printStream.print(context.executeStrategy(data, key));
        }
    }
}









