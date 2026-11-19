class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String cp : cpdomains) {
            String[] part = cp.split(" ");

            int count = Integer.parseInt(part[0]);
            String domain = part[1];

            while (true) {
                map.put(domain, map.getOrDefault(domain, 0) + count);

                int index = domain.indexOf('.');

                if (index == -1) {
                    break;
                }

                domain = domain.substring(index + 1);
            }
        }

        List<String> res = new ArrayList<>();

        for (String domain : map.keySet()) {
            res.add(map.get(domain) + " " + domain);
        }

        return res;
    }
}