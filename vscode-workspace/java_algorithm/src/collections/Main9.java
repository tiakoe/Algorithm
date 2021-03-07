package collections;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

 class Main {

	public static long getSize(File file) {
		if (file.isFile()) {
			return file.length();
		} else {
			try {
                return Files.list(file.toPath()).parallel()
                .mapToLong(e -> getSize(e.toFile())).sum();
			} catch (Exception e) {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String dir = in.nextLine();
		System.out.println(getSize(new File(dir)) + "bytes");
	}

}