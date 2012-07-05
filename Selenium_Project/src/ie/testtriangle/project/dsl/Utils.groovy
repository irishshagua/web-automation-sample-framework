package ie.testtriangle.project.dsl

class Utils {
	
	static randName(numVals) {
		def charSet = 'a'..'z'
		
		GString name = ''
		0.step(numVals, 1) {
			Collections.shuffle(charSet)
			name += charSet.get(0)
		}
		
		return name.capitalize()
	}
}
