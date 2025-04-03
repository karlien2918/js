package org.son.jscloud.t01.search;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.son.jscloud.t01.search.handle.ASearch;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SearchService {

	// [2] 요청을 처리하는 핸들러 인터페이스 (제네릭 사용)
	interface Handler<T, P, R> {
		T getType();
		R handle(P request);
	}

	static class StringHandle implements Handler<String, StringRequest, StringResponse>{

		@Override
		public String getType() {
			return "";
		}

		@Override
		public StringResponse handle(StringRequest request) {
			return null;
		}
	}

	// [3] 핸들러 구현 (StringRequest 전용)
	@Getter
	static class StringRequest {

		private final String data;

		public StringRequest(String data) {
			this.data = data;
		}

	}

	@Getter
	static class StringResponse {

		private final String response;

		StringResponse(String response) {
			this.response = response;
		}

		public String getResponse() {
			return this.response;
		}
	}

	static class HandlerFactory {
		private final Map<String, Handler<? extends Search, ?, ?>> handlerMap = new HashMap<>();

		// 특정 타입의 핸들러 등록 (제네릭 타입)
		public <T, P, R> void registerHandler(String requestType, Handler<T, P, R> handler) {
			handlerMap.put(requestType, (Handler<? extends Search, ?, ?>) handler);
		}

		// 요청 타입에 맞는 핸들러 가져오기
		public <T, P, R> Handler<? extends Search, P, R> getHandler(T requestType) {
			return (Handler<? extends Search, P, R>) handlerMap.get(requestType);
		}
	}

	// [6] 실행 예제

	public void main(String[] args) {

		Job job = new Job();
		// 요청 생성
		StringRequest stringRequest = new StringRequest("Hello, Generics!");
		HandlerFactory handlerFactory = new HandlerFactory();

		// 핸들러 등록
		handlerFactory.registerHandler("StringRequest", new StringHandle());

	}
}
