class TimeMap {
    HashMap<String, ArrayList<TimeStampValues>> hm;

    public TimeMap() {
        hm = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }

            List<TimeStampValues> tsv = hm.get(key);

            tsv.add(new TimeStampValues(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!hm.containsKey(key)) {
                return "";
            }
            var values = hm.get(key);

            Optional<String> result = binarySearch1(values, timestamp);


            return  result.orElse("");

        }

        private Optional<String> binarySearch1(ArrayList<TimeStampValues> values, int timestamp) {
            int l = 0, r = values.size() - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                var timeStampValue = values.get(mid).timeStamp;
                //1,2,3, target= 3

                if (timeStampValue == timestamp) {
                    return Optional.of(values.get(mid).value);
                }

                if (timeStampValue > timestamp) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return r >= 0 ? Optional.of(values.get(r).value) : Optional.of("");
        }

        public static class TimeStampValues {
            private int timeStamp;
            private String value;

            public TimeStampValues(String value, int timeStamp) {
                this.timeStamp = timeStamp;
                this.value = value;
            }
        }
}

