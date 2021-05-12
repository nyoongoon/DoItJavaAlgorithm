public class C4Q3Stack {
    public class IntStack {
        private int max;
        private int ptrA;   //생성자로 초기화 하지 않으면 필드값 초기화 안됌!
        private int ptrB;
        private int[] stk;

        //생성자
        public IntStack(int capacity) {
            max = capacity;
            ptrA = 0;
            ptrB = max - 1;
            try {
                stk = new int[max]; // 스택 본체용 배열 생성
            } catch (OutOfMemoryError e) { //생성할 수 없음
                max = 0;
            }
        }
    }
}
