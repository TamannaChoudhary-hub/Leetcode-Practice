class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] arr = s.split(" ");
            int count = Integer.parseInt(arr[0]);
            String domain = arr[1];
            String[] parts = domain.split("\\.");
            for (int i = 0; i < parts.length; i++) {
                StringBuilder subdomain = new StringBuilder();
                for (int j = i; j < parts.length; j++) {
                    if (j > i) {
                        subdomain.append(".");
                    }
                    subdomain.append(parts[j]);
                }
                map.put(subdomain.toString(),
                        map.getOrDefault(subdomain.toString(), 0) + count);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key) + " " + key);
        }
        return ans;
    }
}