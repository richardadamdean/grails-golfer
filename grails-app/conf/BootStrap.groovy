import com.richardadamdean.golfer.*

class BootStrap {

    def init = { servletContext ->

      def user = new User(id: 1, name: "Richard", updated_at: new Date(), created_at: new Date(), handicap: 2).save(flush: true)
      def course = new Course(id: 1, name: 'My Course', updated_at: new Date(), created_at: new Date())
      course.save(validate: false)
      
      def hole1 = new Hole(holeNumber: 10, course: course).save()
      def hole2 = new Hole(holeNumber: 11, course: course).save()
      course.holes = [hole1, hole2]
      course.save()

    }
    def destroy = {
    }
}
