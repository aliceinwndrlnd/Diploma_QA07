package Rest_Api.AdvtInLiked;

import lombok.Data;

@Data
public class AdvtInLiked {

    private Ad[] ads;
    private Pagination pagination;
    private long total;

}