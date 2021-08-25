package application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class FeedBackKey implements Serializable {

	@Column(name = "film_id")
	Long filmId;


	@Column(name = "userInfo_id")
	Long userInfoId;

}