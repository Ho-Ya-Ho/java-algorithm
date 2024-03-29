package programmers.basicTest.신규아이디추천;

class Solution {
    public String solution(String new_id) {
        return new newIDSuggest(new_id)
                .step1()
                .step2()
                .step3()
                .step4()
                .step5()
                .step6()
                .step7()
                .getNewId();
    }

    private class newIDSuggest {
        private String newId;

        public newIDSuggest(String newId) {
            this.newId = newId;
        }

        public String getNewId() {
            return newId;
        }

        //    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        private newIDSuggest step1() {
            newId = newId.toLowerCase();
            return this;
        }

        //    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        private newIDSuggest step2() {
            StringBuilder sb = new StringBuilder();

            char[] charArray = newId.toCharArray();
            for (char c : charArray) {
                if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c == '-' || c == '_' || c == '.') {
                    sb.append(c);
                }
            }
            newId = sb.toString();
            return this;
        }

        //    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        private newIDSuggest step3() {
            while (newId.contains("..")) {
                newId = newId.replace("..", ".");
            }
            return this;
        }

        //    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        private newIDSuggest step4() {
            if (!newId.isEmpty()) {
                if (newId.charAt(0) == '.') {
                    newId = newId.substring(1);
                }
            }
            if (!newId.isEmpty()) {
                if (newId.charAt(newId.length() -1) == '.') {
                    newId = newId.substring(0, newId.length() -1);
                }
            }
            return this;
        }

        //    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        private newIDSuggest step5() {
            if (newId.isEmpty()) {
                newId = "a";
            }
            return this;
        }

        //    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //    만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        private newIDSuggest step6() {
            if (newId.length() >= 16) {
                newId = newId.substring(0, 15);
            }
            step4();
            return this;
        }

        //    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        private newIDSuggest step7() {
            StringBuilder sb = new StringBuilder(newId);

            if (newId.length() <= 2) {
                char lastText = newId.charAt(newId.length() - 1);
                while (sb.length() < 3) {
                    sb.append(lastText);
                }
            }
            newId = sb.toString();
            return this;
        }
    }
}
