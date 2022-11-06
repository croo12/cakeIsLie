package 남의코드.해석용;

public class 히스토그램 {
	public static void main(String[] args) throws Exception {

		int N;
		int[] histogram = new int[100_000];
		int[] stack = new int[100_000];

		while ((N = next()) > 0) {
			//입력받음
			for (int i = 0; i < N; i++)
				histogram[i] = next();

			//넓이 체크용
			long area = 0;
			//스택의 끝을 가리킴
			int top = -1;

			for (int i = 0; i < N; i++) {
				//!stack.isEmpty() && 마지막으로 스택에 들어간 높이가 현재 높이보다 크거나 같음
				//(전체 사각형의 높이가 낮아지지 않음)
				while (top >= 0 && histogram[stack[top]] >= histogram[i]) {
					int height = histogram[stack[top--]];
					long width = top < 0 ? i : i - 1 - stack[top];
					area = Math.max(area, height * width);
				}
				//??????????
				stack[++top] = i;

			}

			while (top >= 0) {
				int height = histogram[stack[top--]];
				long width = top < 0 ? N : N - 1 - stack[top];
				area = Math.max(area, height * width);
			}

			write(area);

		}

		flush();

	}

	static int iidx, oidx, size, SIZE = 1 << 10;
	static byte[] ibuffer = new byte[SIZE];
	static byte[] obuffer = new byte[SIZE];

	static int next() throws Exception {
		int n = 0;
		byte c;
		while ((c = read()) <= 32)
			;
		do
			n = (n << 3) + (n << 1) + (c & 15);
		while ((c = read()) > 47 && c < 58);
		return n;
	}

	static byte read() throws Exception {
		if (iidx == size) {
			size = System.in.read(ibuffer, iidx = 0, SIZE);
			if (size < 0)
				ibuffer[0] = -1;
		}
		return ibuffer[iidx++];
	}

	static void write(long n) {
		int l = n <= 1 ? 1 : (int) (Math.log10(n) + 1);
		if (oidx + l >= SIZE)
			flush();
		oidx += l;
		for (int i = 1; i <= l; i++) {
			obuffer[oidx - i] = (byte) (n % 10 | 48);
			n /= 10;
		}
		obuffer[oidx++] = 10;
	}

	static void flush() {
		System.out.write(obuffer, 0, oidx);
		oidx = 0;
	}

}
