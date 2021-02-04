package service;

/**
 * @Author szl
 * @Date 2020/12/1 15:30
 * @Description
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -3387516993124229L;
    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
