class Solution {
	int count = 0 ;
	final int CAMERA = 1 ;
	final int MONITORED = 2 ;
	final int NOT_MONITORED = 3 ;

	public int cameraCounter(TreeNode root){

		if(root == null)
			return MONITORED ;

		int leftcall = cameraCounter(root.left) ;
		int rightcall = cameraCounter(root.right) ;

		if(leftcall == NOT_MONITORED || rightcall == NOT_MONITORED){
			count++ ;
			return CAMERA ;
		}

		else if(leftcall == CAMERA || rightcall == CAMERA)
			return MONITORED ;

		else
			return NOT_MONITORED ;


	}

	public int minCameraCover(TreeNode root) {
		return cameraCounter(root) == NOT_MONITORED ? count+1 : count ;
	}
}