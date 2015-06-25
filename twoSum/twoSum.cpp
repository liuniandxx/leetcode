class Solution {
	public:
		vector<int> twoSum(vector<int> &nums, int target) {
			vector<int> result;
			map<int, int> hash;
			for(int i = 0; i < nums.size(); i++) {
				if(hash.find(target - nums[i]) != hash.end()) {
					result.push_back(hash[target - nums[i]] + 1);
					result.push_back(i + 1);
					break;
				} else {
					hash[nums[i]] = i;
				}
			}			
			return result;
		}
};
