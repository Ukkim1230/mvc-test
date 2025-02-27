import java.util.ArrayList;
import java.util.List;

import com.web.dto.FoodInfoDTO;

public class exam {
	
	public static void main(String[] args) {
		List<FoodInfoDTO> foodInfos = new ArrayList<>();
		FoodInfoDTO food = new FoodInfoDTO();
		food.setFiNum(1);
		food.setFiName("김밥");
		food.setFiPrice(3000);
		foodInfos.add(food);
		food = new FoodInfoDTO();
		
		System.out.println(foodInfos.get(0)== foodInfos.get(1));
	}

}
