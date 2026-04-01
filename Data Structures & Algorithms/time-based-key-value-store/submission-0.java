class TimeMap {
    HashMap<String, ArrayList<TimeStampFields>> hm;

    public TimeMap() {
         hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }

            List<TimeStampFields> timeStampFields = hm.get(key);
            timeStampFields.add(new TimeStampFields(value, timestamp)); 
    }
    
     public String get(String key, int timestamp) {
            //  HashMap<String, ArrayList<TimeStampFields>> hm
            if (!hm.containsKey(key)) {
                return "";
            }

            List<TimeStampFields> tsf = hm.get(key);

            Optional<String> result = binarySearchOnTSF(tsf, timestamp);
            return result.orElse("");

        }

        private Optional<String> binarySearchOnTSF(List<TimeStampFields> tsf, int targetTimeStamp) {
            int l = 0, r = tsf.size() - 1;
            // [["happy", 1], ["sad", 2], ["mixed", 3]]

            while (l <= r) {
                int mid = l + (r - l) / 2;
                int midTS = tsf.get(mid).timeStamp;

                if (midTS == targetTimeStamp) {
                    return Optional.of(tsf.get(mid).value);
                }

                if (midTS > targetTimeStamp) {
                    r = mid - 1;
                } else {
                    l = mid + 1;

                }
            }
            return r >= 0 ? Optional.of(tsf.get(r).value) : Optional.empty();

        }

    // class for values
    public static class TimeStampFields {
            private int timeStamp;
            private String value;

            public TimeStampFields(String value, int timeStamp) {
                this.timeStamp = timeStamp;
                this.value = value;
            }

        }
}
